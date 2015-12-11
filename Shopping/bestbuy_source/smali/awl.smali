.class public Lawl;
.super Ljava/lang/Object;

# interfaces
.implements Latv;


# instance fields
.field private a:I

.field private b:Latx;


# direct methods
.method public constructor <init>(Latv;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-interface {p1}, Latv;->c()I

    move-result v0

    iput v0, p0, Lawl;->a:I

    invoke-interface {p1}, Latv;->b()Latx;

    move-result-object v0

    invoke-interface {v0}, Latx;->a()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Latx;

    iput-object v0, p0, Lawl;->b:Latx;

    return-void
.end method


# virtual methods
.method public synthetic a()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lawl;->d()Latv;

    move-result-object v0

    return-object v0
.end method

.method public b()Latx;
    .locals 1

    iget-object v0, p0, Lawl;->b:Latx;

    return-object v0
.end method

.method public c()I
    .locals 1

    iget v0, p0, Lawl;->a:I

    return v0
.end method

.method public d()Latv;
    .locals 0

    return-object p0
.end method
