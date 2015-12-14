.class Lcom/livemixtapes/CommentsPopup$2;
.super Ljava/lang/Object;
.source "CommentsPopup.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/CommentsPopup;->showPopup(Landroid/widget/FrameLayout;Landroid/widget/ImageButton;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/CommentsPopup;

.field private final synthetic val$popupWindow:Landroid/widget/PopupWindow;


# direct methods
.method constructor <init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/PopupWindow;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/CommentsPopup$2;->this$0:Lcom/livemixtapes/CommentsPopup;

    iput-object p2, p0, Lcom/livemixtapes/CommentsPopup$2;->val$popupWindow:Landroid/widget/PopupWindow;

    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 81
    iget-object v1, p0, Lcom/livemixtapes/CommentsPopup$2;->val$popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v1}, Landroid/widget/PopupWindow;->dismiss()V

    .line 82
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/livemixtapes/CommentsPopup$2;->this$0:Lcom/livemixtapes/CommentsPopup;

    iget-object v1, v1, Lcom/livemixtapes/CommentsPopup;->mContext:Landroid/content/Context;

    .line 83
    const-class v2, Lcom/livemixtapes/CommentsActivity;

    .line 82
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 84
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "mixTapeId"

    iget-object v2, p0, Lcom/livemixtapes/CommentsPopup$2;->this$0:Lcom/livemixtapes/CommentsPopup;

    iget-object v2, v2, Lcom/livemixtapes/CommentsPopup;->mixtape:Ljava/util/Map;

    const-string v3, "id"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 85
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 84
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 86
    iget-object v1, p0, Lcom/livemixtapes/CommentsPopup$2;->this$0:Lcom/livemixtapes/CommentsPopup;

    iget-object v1, v1, Lcom/livemixtapes/CommentsPopup;->mContext:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 87
    return-void
.end method
