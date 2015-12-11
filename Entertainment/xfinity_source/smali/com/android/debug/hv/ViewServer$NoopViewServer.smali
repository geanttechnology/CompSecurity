.class Lcom/android/debug/hv/ViewServer$NoopViewServer;
.super Lcom/android/debug/hv/ViewServer;
.source "ViewServer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/debug/hv/ViewServer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "NoopViewServer"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 499
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/debug/hv/ViewServer;-><init>(Lcom/android/debug/hv/ViewServer$1;)V

    .line 500
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/debug/hv/ViewServer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/debug/hv/ViewServer$1;

    .prologue
    .line 498
    invoke-direct {p0}, Lcom/android/debug/hv/ViewServer$NoopViewServer;-><init>()V

    return-void
.end method


# virtual methods
.method public addWindow(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 519
    return-void
.end method

.method public addWindow(Landroid/view/View;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 527
    return-void
.end method

.method public isRunning()Z
    .locals 1

    .prologue
    .line 514
    const/4 v0, 0x0

    return v0
.end method

.method public removeWindow(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 523
    return-void
.end method

.method public removeWindow(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 531
    return-void
.end method

.method public run()V
    .locals 0

    .prologue
    .line 543
    return-void
.end method

.method public setFocusedWindow(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 535
    return-void
.end method

.method public setFocusedWindow(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 539
    return-void
.end method

.method public start()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 504
    const/4 v0, 0x0

    return v0
.end method
