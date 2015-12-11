.class Lcom/poshmark/ui/fragments/FindFriendsFragment$6;
.super Ljava/lang/Object;
.source "FindFriendsFragment.java"

# interfaces
.implements Lcom/poshmark/ui/fragments/FindFriendsFragment$FetchFBFriendsCompletionsCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FindFriendsFragment;->getExternalConnections()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V
    .locals 0

    .prologue
    .line 228
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public callFinished(Z)V
    .locals 1
    .param p1, "success"    # Z

    .prologue
    .line 231
    if-eqz p1, :cond_0

    .line 232
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FindFriendsFragment$6;->this$0:Lcom/poshmark/ui/fragments/FindFriendsFragment;

    # invokes: Lcom/poshmark/ui/fragments/FindFriendsFragment;->getSuggestedUsers()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/FindFriendsFragment;->access$200(Lcom/poshmark/ui/fragments/FindFriendsFragment;)V

    .line 234
    :cond_0
    return-void
.end method
