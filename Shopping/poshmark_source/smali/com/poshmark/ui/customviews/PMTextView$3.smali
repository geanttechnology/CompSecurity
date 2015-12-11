.class Lcom/poshmark/ui/customviews/PMTextView$3;
.super Ljava/lang/Object;
.source "PMTextView.java"

# interfaces
.implements Lcom/poshmark/utils/TextClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/PMTextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/PMTextView;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/PMTextView;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTextView$3;->this$0:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Ljava/lang/String;)V
    .locals 4
    .param p1, "listingID"    # Ljava/lang/String;

    .prologue
    .line 64
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 65
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->LIKES_MODE:Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/UserListFragment$USER_LIST_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    const-string v2, "ID"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMTextView$3;->this$0:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMTextView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 68
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/UserListFragment;

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 70
    return-void
.end method
