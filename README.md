# Bagevent-web

## 使用技术

### React

#### 什么是React？

> 前端三大主流框架之一

React是一个用户构建用户界面的JavaScript库。

#### 什么是React组件？

组件是页面上的一部分，一个网页可以拆分成很多小的分部。列如：导航栏、侧边栏、底部，导航栏中又包含LOGO、搜索框、菜单，其中搜索框又包含input组件和button组件。

```js
import React from 'react';
class App extends React.Component {
　　render() {
　　　　return (
　　　　　　<div className="App">
　　　　　　　　hello world
　　　　　　</div>
　　　　);
　　}
}
export default App;
```

#### React常用生命周期函数有哪些？

> 三个阶段：加载阶段（Mounting），更新阶段（Update），卸载阶段（UnMounting）

- constructor: 组件被加载前最先调用，仅调用一次

- componentwillmount: 组件初始渲染（render()）前调用，仅调用一次

- render: componentwillmount之后，componentDidMount之前， 渲染挂载组件

- componentDidMount: render之后被调用，仅调用一次

- shouldComponentUpdate(nextProps,nextState): 组件挂载后（render），接收到新得props和state时调用

- componentWillUpdate: 在接收到新得props或者state，重新渲染前立刻调用， 在初始化渲染的时候不会被调用

- componentDidUpdate: 重新渲染后调用，在初始化渲染时该方法不会被调用

- componentWillUnmount: 组件被卸载前调用




