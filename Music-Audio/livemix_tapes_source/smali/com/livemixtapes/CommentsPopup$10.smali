.class Lcom/livemixtapes/CommentsPopup$10;
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
    iput-object p1, p0, Lcom/livemixtapes/CommentsPopup$10;->this$0:Lcom/livemixtapes/CommentsPopup;

    iput-object p2, p0, Lcom/livemixtapes/CommentsPopup$10;->val$popupWindow:Landroid/widget/PopupWindow;

    .line 174
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 177
    iget-object v2, p0, Lcom/livemixtapes/CommentsPopup$10;->val$popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    .line 178
    iget-object v2, p0, Lcom/livemixtapes/CommentsPopup$10;->this$0:Lcom/livemixtapes/CommentsPopup;

    iget-object v2, v2, Lcom/livemixtapes/CommentsPopup;->mActivity:Landroid/app/Activity;

    const-string v3, "clipboard"

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ClipboardManager;

    .line 179
    .local v1, "clipboard":Landroid/content/ClipboardManager;
    const-string v3, "label"

    .line 180
    iget-object v2, p0, Lcom/livemixtapes/CommentsPopup$10;->this$0:Lcom/livemixtapes/CommentsPopup;

    iget-object v2, v2, Lcom/livemixtapes/CommentsPopup;->mixtape:Ljava/util/Map;

    const-string v4, "sharetext"

    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 179
    invoke-static {v3, v2}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v0

    .line 181
    .local v0, "clip":Landroid/content/ClipData;
    invoke-virtual {v1, v0}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 182
    return-void
.end method
