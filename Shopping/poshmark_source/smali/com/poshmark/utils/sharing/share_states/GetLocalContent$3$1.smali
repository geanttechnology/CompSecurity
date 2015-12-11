.class Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3$1;
.super Ljava/lang/Object;
.source "GetLocalContent.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3$1;->this$1:Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public dialogDismissed()V
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3$1;->this$1:Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent$3;->this$0:Lcom/poshmark/utils/sharing/share_states/GetLocalContent;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/GetLocalContent;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateFailed()V

    .line 112
    return-void
.end method
