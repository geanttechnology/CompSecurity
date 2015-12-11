.class public abstract Lorg/springframework/beans/PropertyAccessException;
.super Lorg/springframework/beans/BeansException;
.source "PropertyAccessException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Lorg/springframework/beans/BeansException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 57
    return-void
.end method
