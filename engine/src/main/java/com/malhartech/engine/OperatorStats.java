package com.malhartech.engine;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Operator stats, which forms the root of a tree like structure.
 * Can be serialized as object or marshaled as JSON for easy consumption by client.
 */
public class OperatorStats implements Serializable {
  private static final long serialVersionUID = 1L;

  public static class PortStats implements Serializable
  {
    private static final long serialVersionUID = 1L;

    public final String portname;
    public final int processedCount;

    PortStats(String name, int count)
    {
      portname = name;
      processedCount= count;
    }
  }

  public long windowId;
  public ArrayList<PortStats> inputPorts;
  public ArrayList<PortStats> outputPorts;
  public Long latency = null;
  public long cpuTimeUsed;
}
