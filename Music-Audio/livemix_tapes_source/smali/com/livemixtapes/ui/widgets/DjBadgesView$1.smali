.class Lcom/livemixtapes/ui/widgets/DjBadgesView$1;
.super Ljava/lang/Object;
.source "DjBadgesView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/ui/widgets/DjBadgesView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/ui/widgets/DjBadgesView;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ui/widgets/DjBadgesView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;->this$0:Lcom/livemixtapes/ui/widgets/DjBadgesView;

    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 91
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;->this$0:Lcom/livemixtapes/ui/widgets/DjBadgesView;

    # getter for: Lcom/livemixtapes/ui/widgets/DjBadgesView;->djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->access$0(Lcom/livemixtapes/ui/widgets/DjBadgesView;)Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 92
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;->this$0:Lcom/livemixtapes/ui/widgets/DjBadgesView;

    # getter for: Lcom/livemixtapes/ui/widgets/DjBadgesView;->djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->access$0(Lcom/livemixtapes/ui/widgets/DjBadgesView;)Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

    move-result-object v0

    check-cast p1, Landroid/widget/TextView;

    .end local p1    # "v":Landroid/view/View;
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;->onClickDj(Ljava/lang/String;)V

    .line 94
    :cond_0
    return-void
.end method
