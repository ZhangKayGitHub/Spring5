package com.kay.proxy;

/**
 * 对生产厂家要求的一个接口
 */
public interface IProducer{
    /**
     * 销售
     *
     * @param money
     */
    void saleProduct(float money);

    /**
     * 售后
     *
     * @param money
     */
    void afterService(float money);

}
