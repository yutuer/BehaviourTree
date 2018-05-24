package com.lizhao.ai.itf;

import com.lizhao.ai.EStatus;

/**
 * Behavior接口是所有行为树节点的核心，且我规定所有节点的构造和析构方法都必须是protected，以防止在栈上创建对象，
 * 所有的节点对象通过Create()静态方法在堆上创建，通过Release()方法销毁
 * 由于Behavior是个抽象接口，故没有提供Create()方法，本接口满足如下契约
 * 在Update方法被首次调用前，调用一次OnInitialize函数，负责初始化等操作
 * Update（）方法在行为树每次更新时调用且仅调用一次。
 * 当行为不再处于运行状态时，调用一次OnTerminate（），并根据返回状态不同执行不同的逻辑
 */
public interface IBehavior {
  //
  //  //创建对象请调用Create()释放对象请调用Release()
  //  protected Behavior() {
  //    setStatus(EStatus.Invalid);
  //  }


  //包装函数，防止打破调用契约
  EStatus tick();

  void addChild(IBehavior child);

  EStatus update();

  void onInitialize();

  void onTerminate(EStatus Status);

  //释放对象所占资源
  void release();

  void setStatus(EStatus status);

  EStatus getStatus();
};