.class Lcom/livemixtapes/CommentsPopup$7;
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
    iput-object p1, p0, Lcom/livemixtapes/CommentsPopup$7;->this$0:Lcom/livemixtapes/CommentsPopup;

    iput-object p2, p0, Lcom/livemixtapes/CommentsPopup$7;->val$popupWindow:Landroid/widget/PopupWindow;

    .line 132
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 135
    iget-object v1, p0, Lcom/livemixtapes/CommentsPopup$7;->val$popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v1}, Landroid/widget/PopupWindow;->dismiss()V

    .line 136
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 137
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "mailto:"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 138
    const-string v1, "plain/text"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 139
    const-string v2, "android.intent.extra.SUBJECT"

    .line 140
    iget-object v1, p0, Lcom/livemixtapes/CommentsPopup$7;->this$0:Lcom/livemixtapes/CommentsPopup;

    iget-object v1, v1, Lcom/livemixtapes/CommentsPopup;->mixtape:Ljava/util/Map;

    const-string v3, "title"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 139
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 141
    const-string v2, "android.intent.extra.TEXT"

    .line 142
    iget-object v1, p0, Lcom/livemixtapes/CommentsPopup$7;->this$0:Lcom/livemixtapes/CommentsPopup;

    iget-object v1, v1, Lcom/livemixtapes/CommentsPopup;->mixtape:Ljava/util/Map;

    const-string v3, "sharetext"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 141
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 143
    iget-object v1, p0, Lcom/livemixtapes/CommentsPopup$7;->this$0:Lcom/livemixtapes/CommentsPopup;

    iget-object v1, v1, Lcom/livemixtapes/CommentsPopup;->mContext:Landroid/content/Context;

    .line 144
    const-string v2, "Send Email"

    invoke-static {v0, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v2

    .line 143
    invoke-virtual {v1, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 145
    return-void
.end method
