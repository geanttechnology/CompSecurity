.class Lcom/poshmark/ui/MainActivity$3;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/MainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/MainActivity;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/MainActivity;)V
    .locals 0

    .prologue
    .line 818
    iput-object p1, p0, Lcom/poshmark/ui/MainActivity$3;->this$0:Lcom/poshmark/ui/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTabSelected(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 4
    .param p1, "tab"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 822
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 823
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "NEW_LISTING"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 824
    iget-object v1, p0, Lcom/poshmark/ui/MainActivity$3;->this$0:Lcom/poshmark/ui/MainActivity;

    const-class v2, Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/MainActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 825
    return-void
.end method

.method public onTabUnselected(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 0
    .param p1, "tab"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 830
    return-void
.end method
