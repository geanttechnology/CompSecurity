.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteInfo;
.super Ljava/lang/Object;
.source "RouteInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteInfo$LayerType;,
        Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteInfo$TunnelType;
    }
.end annotation


# virtual methods
.method public abstract getHopCount()I
.end method

.method public abstract getHopTarget(I)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
.end method

.method public abstract getLayerType()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteInfo$LayerType;
.end method

.method public abstract getLocalAddress()Ljava/net/InetAddress;
.end method

.method public abstract getProxyHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
.end method

.method public abstract getTargetHost()Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
.end method

.method public abstract getTunnelType()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteInfo$TunnelType;
.end method

.method public abstract isLayered()Z
.end method

.method public abstract isSecure()Z
.end method

.method public abstract isTunnelled()Z
.end method
