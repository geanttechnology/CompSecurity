.class public Ltv/freewheel/hybrid/utils/CommonUtil;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# direct methods
.method public static final currentThreadIdentifier()Ljava/lang/String;
    .locals 4

    .prologue
    .line 5
    const-string v0, "[0x%x]"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
