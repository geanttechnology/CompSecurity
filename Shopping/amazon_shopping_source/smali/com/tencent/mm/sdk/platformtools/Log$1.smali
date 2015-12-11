.class final Lcom/tencent/mm/sdk/platformtools/Log$1;
.super Ljava/lang/Object;
.source "Log.java"

# interfaces
.implements Lcom/tencent/mm/sdk/platformtools/Log$LogImp;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/sdk/platformtools/Log;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLogLevel()I
    .locals 1

    .prologue
    .line 100
    # getter for: Lcom/tencent/mm/sdk/platformtools/Log;->level:I
    invoke-static {}, Lcom/tencent/mm/sdk/platformtools/Log;->access$000()I

    move-result v0

    return v0
.end method

.method public logD(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJJLjava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "filename"    # Ljava/lang/String;
    .param p3, "funcname"    # Ljava/lang/String;
    .param p4, "line"    # I
    .param p5, "pid"    # I
    .param p6, "tid"    # J
    .param p8, "maintid"    # J
    .param p10, "log"    # Ljava/lang/String;

    .prologue
    .line 63
    # getter for: Lcom/tencent/mm/sdk/platformtools/Log;->level:I
    invoke-static {}, Lcom/tencent/mm/sdk/platformtools/Log;->access$000()I

    move-result v0

    const/4 v1, 0x1

    if-gt v0, v1, :cond_0

    .line 64
    invoke-static {p1, p10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 67
    :cond_0
    return-void
.end method

.method public logE(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJJLjava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "filename"    # Ljava/lang/String;
    .param p3, "funcname"    # Ljava/lang/String;
    .param p4, "line"    # I
    .param p5, "pid"    # I
    .param p6, "tid"    # J
    .param p8, "maintid"    # J
    .param p10, "log"    # Ljava/lang/String;

    .prologue
    .line 79
    # getter for: Lcom/tencent/mm/sdk/platformtools/Log;->level:I
    invoke-static {}, Lcom/tencent/mm/sdk/platformtools/Log;->access$000()I

    move-result v0

    const/4 v1, 0x4

    if-gt v0, v1, :cond_0

    .line 80
    invoke-static {p1, p10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    :cond_0
    return-void
.end method

.method public logI(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJJLjava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "filename"    # Ljava/lang/String;
    .param p3, "funcname"    # Ljava/lang/String;
    .param p4, "line"    # I
    .param p5, "pid"    # I
    .param p6, "tid"    # J
    .param p8, "maintid"    # J
    .param p10, "log"    # Ljava/lang/String;

    .prologue
    .line 56
    # getter for: Lcom/tencent/mm/sdk/platformtools/Log;->level:I
    invoke-static {}, Lcom/tencent/mm/sdk/platformtools/Log;->access$000()I

    move-result v0

    const/4 v1, 0x2

    if-gt v0, v1, :cond_0

    .line 57
    invoke-static {p1, p10}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 59
    :cond_0
    return-void
.end method
