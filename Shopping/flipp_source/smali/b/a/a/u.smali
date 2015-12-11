.class public final Lb/a/a/u;
.super Lb/a/a/c/a;
.source "SourceFile"


# instance fields
.field public a:Lb/a/a/t;

.field public b:Lb/a/a/c;


# direct methods
.method public constructor <init>(Lb/a/a/t;Lb/a/a/c;)V
    .locals 0

    .prologue
    .line 1270
    invoke-direct {p0}, Lb/a/a/c/a;-><init>()V

    .line 1271
    iput-object p1, p0, Lb/a/a/u;->a:Lb/a/a/t;

    .line 1272
    iput-object p2, p0, Lb/a/a/u;->b:Lb/a/a/c;

    .line 1273
    return-void
.end method


# virtual methods
.method public final a()Lb/a/a/c;
    .locals 1

    .prologue
    .line 1299
    iget-object v0, p0, Lb/a/a/u;->b:Lb/a/a/c;

    return-object v0
.end method

.method protected final b()J
    .locals 2

    .prologue
    .line 1308
    iget-object v0, p0, Lb/a/a/u;->a:Lb/a/a/t;

    iget-wide v0, v0, Lb/a/a/a/d;->a:J

    return-wide v0
.end method

.method protected final c()Lb/a/a/a;
    .locals 1

    .prologue
    .line 1318
    iget-object v0, p0, Lb/a/a/u;->a:Lb/a/a/t;

    iget-object v0, v0, Lb/a/a/a/d;->b:Lb/a/a/a;

    return-object v0
.end method
