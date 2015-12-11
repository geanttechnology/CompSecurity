.class public Lcom/poshmark/utils/InvalidShareCallerException;
.super Lcom/poshmark/utils/PMException;
.source "InvalidShareCallerException.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    const-string v0, "An Activity or a fragment class needs to be passed in as the first parameter!"

    invoke-direct {p0, v0}, Lcom/poshmark/utils/PMException;-><init>(Ljava/lang/String;)V

    .line 9
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 12
    const-string v0, "An Activity or a fragment class needs to be passed in as the first parameter!"

    invoke-direct {p0, v0, p1}, Lcom/poshmark/utils/PMException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 13
    return-void
.end method
