.class Lcom/livemixtapes/CommentsPopup$5;
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
    iput-object p1, p0, Lcom/livemixtapes/CommentsPopup$5;->this$0:Lcom/livemixtapes/CommentsPopup;

    iput-object p2, p0, Lcom/livemixtapes/CommentsPopup$5;->val$popupWindow:Landroid/widget/PopupWindow;

    .line 112
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 115
    iget-object v0, p0, Lcom/livemixtapes/CommentsPopup$5;->val$popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 116
    iget-object v0, p0, Lcom/livemixtapes/CommentsPopup$5;->this$0:Lcom/livemixtapes/CommentsPopup;

    const-string v1, "com.twitter.android"

    invoke-virtual {v0, v1}, Lcom/livemixtapes/CommentsPopup;->shareSocialNetworks(Ljava/lang/String;)V

    .line 117
    return-void
.end method
