.class public final Lax;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Lag;

.field private final b:Lao;

.field private final c:Lab;


# direct methods
.method public constructor <init>(Lag;Lao;Lab;)V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-object p1, p0, Lax;->a:Lag;

    .line 36
    iput-object p2, p0, Lax;->b:Lao;

    .line 37
    iput-object p3, p0, Lax;->c:Lab;

    .line 38
    return-void
.end method

.method static synthetic a(Lax;)Lab;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lax;->c:Lab;

    return-object v0
.end method

.method static synthetic b(Lax;)Lag;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lax;->a:Lag;

    return-object v0
.end method

.method static synthetic c(Lax;)Lao;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lax;->b:Lao;

    return-object v0
.end method
