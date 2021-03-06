/**
 * Copyright (C) 2015 DataTorrent, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datatorrent.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * <p>Stats interface.</p>
 *
 * @since 0.9.1
 */
public interface Stats extends Serializable
{
  public static final long INVALID_TIME_MILLIS = -1;

  interface Checkpoint extends Serializable
  {
    long getWindowId();
  }

  public static class OperatorStats implements Stats
  {
    public long windowId;
    public Checkpoint checkpoint;
    public ArrayList<PortStats> inputPorts;
    public ArrayList<PortStats> outputPorts;
    public long cpuTimeUsed;
    /**
     * @deprecated use {@link #customMetrics}
     */
    @Deprecated
    public Object counters;
    public Map<String, Object> customMetrics;

    /**
     * If there is a recording on the operator, this contains the recording id, otherwise null
     */
    public String recordingId;

    public static class PortStats implements Stats
    {
      private static final long serialVersionUID = 201309131906L;
      public final String id;
      public int tupleCount;
      public long endWindowTimestamp;
      public long bufferServerBytes;
      public int queueSize;
      /**
       * If there is a recording on the port, this contains the recording id, otherwise null
       */
      public String recordingId;

      public PortStats(String id)
      {
        this.id = id;
      }

      @Override
      public String toString()
      {
        return "PortStats{" + "portname=" + id + ", processedCount=" + tupleCount + ", bufferServerBytes = " + bufferServerBytes + ", queueSize = " + queueSize + ", endWindowTimestamp=" + endWindowTimestamp + '}';
      }

    }

    @Override
    public String toString()
    {
      return "OperatorStats{" + "windowId=" + windowId + ", checkpointedWindowId=" + checkpoint + ", inputPorts=" + inputPorts + ", outputPorts=" + outputPorts + ", cpuTimeUsed=" + cpuTimeUsed + '}';
    }

    private static final long serialVersionUID = 201309131905L;
  }

}
