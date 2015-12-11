.class Lcom/poshmark/ui/fragments/AboutFragment$1;
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
    .line 51
    iput-object p1, p0, Lcom/poshmark/ui/fragments/AboutFragment$1;->this$0:Lcom/poshmark/ui/fragments/AboutFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AboutFragment$1;->this$0:Lcom/poshmark/ui/fragments/AboutFragment;

    const-string v1, "/mapp/terms_and_conditions"

    const-string v2, "terms_and_conditions_screen"

    # invokes: Lcom/poshmark/ui/fragments/AboutFragment;->launchUrl(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/poshmark/ui/fragments/AboutFragment;->access$000(Lcom/poshmark/ui/fragments/AboutFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    return-void
.end method
