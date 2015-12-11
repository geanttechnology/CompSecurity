.class Lcom/poshmark/ui/fragments/UserSettingsFragment$3;
.super Ljava/lang/Object;
.source "UserSettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/UserSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserSettingsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V
    .locals 0

    .prologue
    .line 340
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 343
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .line 344
    .local v0, "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    if-eqz v0, :cond_0

    .line 345
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment$3;->this$0:Lcom/poshmark/ui/fragments/UserSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/UserSettingsFragment;->launchUrl(Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;)V
    invoke-static {v1, v0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->access$000(Lcom/poshmark/ui/fragments/UserSettingsFragment;Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;)V

    .line 348
    :cond_0
    return-void
.end method
