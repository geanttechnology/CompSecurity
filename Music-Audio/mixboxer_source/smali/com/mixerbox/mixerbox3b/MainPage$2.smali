.class Lcom/mixerbox/mixerbox3b/MainPage$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 532
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$2;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 535
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$2;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setPlaylists(Z)V

    .line 536
    return-void
.end method
