.class Lzw$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lzw;->a()V
.end annotation


# instance fields
.field final synthetic a:Lzw;


# direct methods
.method constructor <init>(Lzw;)V
    .locals 0

    iput-object p1, p0, Lzw$1;->a:Lzw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Lzw$1;->a:Lzw;

    invoke-virtual {v0}, Lzw;->b()V

    return-void
.end method
