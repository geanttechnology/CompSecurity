.class Lcom/livemixtapes/Mixtape$3;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$3;->this$0:Lcom/livemixtapes/Mixtape;

    .line 287
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 292
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 294
    .local v0, "sharingIntent":Landroid/content/Intent;
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 296
    const-string v2, "android.intent.extra.SUBJECT"

    .line 297
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$3;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v1, v1, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v3, "title"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 296
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 299
    const-string v2, "android.intent.extra.TEXT"

    .line 302
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$3;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v1, v1, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v3, "sharetext"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 299
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 304
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$3;->this$0:Lcom/livemixtapes/Mixtape;

    const-string v2, "Share using"

    invoke-static {v0, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/livemixtapes/Mixtape;->startActivity(Landroid/content/Intent;)V

    .line 305
    return-void
.end method
