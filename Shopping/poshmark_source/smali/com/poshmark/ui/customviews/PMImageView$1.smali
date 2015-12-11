.class Lcom/poshmark/ui/customviews/PMImageView$1;
.super Ljava/lang/Object;
.source "PMImageView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMImageView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMImageView;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMImageView$1;->this$0:Lcom/poshmark/ui/customviews/PMImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 29
    check-cast p1, Lcom/poshmark/ui/customviews/PMImageView;

    .end local p1    # "v":Landroid/view/View;
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMImageView;->launchFragmentOnClick()V

    .line 30
    return-void
.end method
