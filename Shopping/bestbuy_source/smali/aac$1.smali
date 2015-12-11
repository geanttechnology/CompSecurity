.class Laac$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laac;->a()V
.end annotation


# instance fields
.field final synthetic a:Laac;


# direct methods
.method constructor <init>(Laac;)V
    .locals 0

    iput-object p1, p0, Laac$1;->a:Laac;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Laac$1;->a:Laac;

    invoke-virtual {v0}, Laac;->b()V

    return-void
.end method
