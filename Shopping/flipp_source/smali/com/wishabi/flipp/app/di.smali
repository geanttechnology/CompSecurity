.class final Lcom/wishabi/flipp/app/di;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/ff;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/MainActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/MainActivity;)V
    .locals 0

    .prologue
    .line 444
    iput-object p1, p0, Lcom/wishabi/flipp/app/di;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 1

    .prologue
    .line 452
    iget-object v0, p0, Lcom/wishabi/flipp/app/di;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->a(Lcom/wishabi/flipp/app/MainActivity;)Lcom/wishabi/flipp/app/SearchFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/SearchFragment;->a()V

    .line 453
    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 447
    iget-object v0, p0, Lcom/wishabi/flipp/app/di;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->a(Lcom/wishabi/flipp/app/MainActivity;)Lcom/wishabi/flipp/app/SearchFragment;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/wishabi/flipp/app/SearchFragment;->a(Ljava/lang/String;Z)V

    .line 448
    return-void
.end method
