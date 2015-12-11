.class final Lcom/wishabi/flipp/b/ae;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/b/ac;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/ac;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/wishabi/flipp/b/ae;->a:Lcom/wishabi/flipp/b/ac;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .prologue
    .line 118
    iget-object v0, p0, Lcom/wishabi/flipp/b/ae;->a:Lcom/wishabi/flipp/b/ac;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    const/4 v1, 0x0

    const/4 v2, 0x4

    invoke-static {v0, v1, v2}, Lcom/wishabi/flipp/b/ab;->a(Lcom/wishabi/flipp/b/ab;Landroid/location/Location;I)V

    .line 119
    return-void
.end method
