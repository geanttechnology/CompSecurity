.class public abstract Lcom/livemixtapes/User$SignupCallback;
.super Ljava/lang/Object;
.source "User.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/User;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "SignupCallback"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract always()V
.end method

.method protected abstract failure(ILjava/lang/Exception;)V
.end method

.method protected abstract signup_failure(Ljava/lang/String;)V
.end method

.method protected abstract success()V
.end method
