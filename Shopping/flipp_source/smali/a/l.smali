.class final La/l;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements La/g;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "La/g",
        "<TTResult;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:La/o;

.field final synthetic b:La/g;

.field final synthetic c:Ljava/util/concurrent/Executor;

.field final synthetic d:La/h;


# direct methods
.method constructor <init>(La/h;La/o;La/g;Ljava/util/concurrent/Executor;)V
    .locals 0

    .prologue
    .line 339
    iput-object p1, p0, La/l;->d:La/h;

    iput-object p2, p0, La/l;->a:La/o;

    iput-object p3, p0, La/l;->b:La/g;

    iput-object p4, p0, La/l;->c:Ljava/util/concurrent/Executor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final synthetic then(La/h;)Ljava/lang/Object;
    .locals 3

    .prologue
    .line 339
    iget-object v0, p0, La/l;->a:La/o;

    iget-object v1, p0, La/l;->b:La/g;

    iget-object v2, p0, La/l;->c:Ljava/util/concurrent/Executor;

    invoke-static {v0, v1, p1, v2}, La/h;->b(La/o;La/g;La/h;Ljava/util/concurrent/Executor;)V

    const/4 v0, 0x0

    return-object v0
.end method
