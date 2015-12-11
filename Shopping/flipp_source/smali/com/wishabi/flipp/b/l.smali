.class public final Lcom/wishabi/flipp/b/l;
.super Ljava/util/TimerTask;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/content/Flyer$Model;

.field final synthetic b:Lcom/wishabi/flipp/b/a;


# direct methods
.method public constructor <init>(Lcom/wishabi/flipp/b/a;Lcom/wishabi/flipp/content/Flyer$Model;)V
    .locals 0

    .prologue
    .line 514
    iput-object p1, p0, Lcom/wishabi/flipp/b/l;->b:Lcom/wishabi/flipp/b/a;

    iput-object p2, p0, Lcom/wishabi/flipp/b/l;->a:Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 517
    iget-object v0, p0, Lcom/wishabi/flipp/b/l;->b:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/b/l;->a:Lcom/wishabi/flipp/content/Flyer$Model;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/Flyer$Model;)V

    .line 518
    return-void
.end method
