.class Lio$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio;->b()V
.end annotation


# instance fields
.field final synthetic a:Lio;


# direct methods
.method constructor <init>(Lio;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lio$2;->a:Lio;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 74
    iget-object v0, p0, Lio$2;->a:Lio;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lio;->a(Lio;I)I

    .line 75
    return-void
.end method
