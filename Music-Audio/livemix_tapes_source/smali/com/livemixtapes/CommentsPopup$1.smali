.class Lcom/livemixtapes/CommentsPopup$1;
.super Ljava/lang/Object;
.source "CommentsPopup.java"

# interfaces
.implements Landroid/widget/PopupWindow$OnDismissListener;


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

.field private final synthetic val$frameLayout:Landroid/widget/FrameLayout;


# direct methods
.method constructor <init>(Lcom/livemixtapes/CommentsPopup;Landroid/widget/FrameLayout;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/CommentsPopup$1;->this$0:Lcom/livemixtapes/CommentsPopup;

    iput-object p2, p0, Lcom/livemixtapes/CommentsPopup$1;->val$frameLayout:Landroid/widget/FrameLayout;

    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss()V
    .locals 2

    .prologue
    .line 72
    iget-object v0, p0, Lcom/livemixtapes/CommentsPopup$1;->val$frameLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getForeground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 73
    return-void
.end method
