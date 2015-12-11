.class final Lcom/wishabi/flipp/app/bk;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lcom/wishabi/flipp/app/bj;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bj;Z)V
    .locals 0

    .prologue
    .line 468
    iput-object p1, p0, Lcom/wishabi/flipp/app/bk;->b:Lcom/wishabi/flipp/app/bj;

    iput-boolean p2, p0, Lcom/wishabi/flipp/app/bk;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 471
    iget-object v0, p0, Lcom/wishabi/flipp/app/bk;->b:Lcom/wishabi/flipp/app/bj;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bj;->a:Lcom/wishabi/flipp/app/bi;

    iget-object v0, v0, Lcom/wishabi/flipp/app/bi;->b:Lcom/wishabi/flipp/app/FlyerCarouselFragment;

    iget-boolean v1, p0, Lcom/wishabi/flipp/app/bk;->a:Z

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/FlyerCarouselFragment;->d(Lcom/wishabi/flipp/app/FlyerCarouselFragment;Z)V

    .line 472
    return-void
.end method
