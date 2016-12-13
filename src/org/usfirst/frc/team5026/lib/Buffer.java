package org.usfirst.frc.team5026.lib;

public class Buffer {
    private double[] buffer;
    private int replaceIndex = 0;
    public double sum = 0;

    public Buffer(int bufferSize) {
        buffer = new double[bufferSize];
    }

    public double push(double value) {
        sum -= buffer[replaceIndex];
        sum += value;
        
        buffer[replaceIndex]  = value;
        replaceIndex++;
        
        if (replaceIndex == buffer.length) {
            replaceIndex = 0;
        }
        
        return sum;
    }

}
