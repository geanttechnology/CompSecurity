.class public Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;
.super Ljava/lang/Object;
.source "ConnectivityRequiredOnClickListener.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private runnable:Ljava/lang/Runnable;

.field private uiUtil:Lcom/comcast/cim/utils/UIUtil;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/utils/UIUtil;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "uiUtil"    # Lcom/comcast/cim/utils/UIUtil;
    .param p2, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    .line 13
    iput-object p2, p0, Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;->runnable:Ljava/lang/Runnable;

    .line 14
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;->runnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/utils/UIUtil;->ensureConnectivityBeforeExecuting(Landroid/content/Context;Ljava/lang/Runnable;)V

    .line 19
    return-void
.end method
