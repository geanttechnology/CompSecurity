.class Lcom/comcast/cim/utils/UIUtil$1;
.super Ljava/lang/Object;
.source "UIUtil.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/utils/UIUtil;->ensureConnectivityBeforeExecuting(Landroid/content/Context;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/utils/UIUtil;

.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$runnable:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/comcast/cim/utils/UIUtil;Landroid/content/Context;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/utils/UIUtil;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/comcast/cim/utils/UIUtil$1;->this$0:Lcom/comcast/cim/utils/UIUtil;

    iput-object p2, p0, Lcom/comcast/cim/utils/UIUtil$1;->val$context:Landroid/content/Context;

    iput-object p3, p0, Lcom/comcast/cim/utils/UIUtil$1;->val$runnable:Ljava/lang/Runnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public tryAgain()V
    .locals 3

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/utils/UIUtil$1;->this$0:Lcom/comcast/cim/utils/UIUtil;

    iget-object v1, p0, Lcom/comcast/cim/utils/UIUtil$1;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lcom/comcast/cim/utils/UIUtil$1;->val$runnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/utils/UIUtil;->ensureConnectivityBeforeExecuting(Landroid/content/Context;Ljava/lang/Runnable;)V

    .line 77
    return-void
.end method
