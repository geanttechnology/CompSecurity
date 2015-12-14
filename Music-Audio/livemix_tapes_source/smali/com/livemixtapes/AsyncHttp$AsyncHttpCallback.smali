.class public abstract Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.super Ljava/lang/Object;
.source "AsyncHttp.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/AsyncHttp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "AsyncHttpCallback"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract always()V
.end method

.method protected abstract exception(Ljava/lang/Exception;)V
.end method

.method protected abstract success(Ljava/lang/String;Ljava/lang/String;I)V
.end method
