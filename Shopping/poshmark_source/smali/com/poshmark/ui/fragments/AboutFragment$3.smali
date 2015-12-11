.class Lcom/poshmark/ui/fragments/AboutFragment$3;
.super Ljava/lang/Object;
.source "AboutFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/AboutFragment;->setupButtons()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/AboutFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/AboutFragment;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/poshmark/ui/fragments/AboutFragment$3;->this$0:Lcom/poshmark/ui/fragments/AboutFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AboutFragment$3;->this$0:Lcom/poshmark/ui/fragments/AboutFragment;

    const-string v1, "Coming Soon"

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/AboutFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;)V

    .line 70
    return-void
.end method
