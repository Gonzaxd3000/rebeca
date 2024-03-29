package edu.cmu.cs.stage3.alice.scenegraph.renderer.directx7renderer;

class TorusProxy extends edu.cmu.cs.stage3.alice.scenegraph.renderer.nativerenderer.TorusProxy {
    //from ElementProxy
    protected native void createNativeInstance();
    protected native void releaseNativeInstance();
    //from GeometryProxy
    protected native void onBoundChange( double x, double y, double z, double radius );
    //from TorusProxy
	protected native void onInnerRadiusChange( double value );
	protected native void onOuterRadiusChange( double value );
}