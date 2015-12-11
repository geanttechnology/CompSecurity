.class public final Lnx;
.super Ljava/lang/Object;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field public static final a:Lnx;

.field public static final b:Lnx;

.field public static final c:Lnx;

.field public static final d:Lnx;

.field public static final e:Lnx;

.field public static final f:Lnx;


# instance fields
.field private final g:Loo;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    new-instance v0, Lnx;

    const/4 v1, -0x1

    const/4 v2, -0x2

    const-string v3, "mb"

    invoke-direct {v0, v1, v2, v3}, Lnx;-><init>(IILjava/lang/String;)V

    sput-object v0, Lnx;->a:Lnx;

    new-instance v0, Lnx;

    const/16 v1, 0x140

    const/16 v2, 0x32

    const-string v3, "mb"

    invoke-direct {v0, v1, v2, v3}, Lnx;-><init>(IILjava/lang/String;)V

    sput-object v0, Lnx;->b:Lnx;

    new-instance v0, Lnx;

    const/16 v1, 0x12c

    const/16 v2, 0xfa

    const-string v3, "as"

    invoke-direct {v0, v1, v2, v3}, Lnx;-><init>(IILjava/lang/String;)V

    sput-object v0, Lnx;->c:Lnx;

    new-instance v0, Lnx;

    const/16 v1, 0x1d4

    const/16 v2, 0x3c

    const-string v3, "as"

    invoke-direct {v0, v1, v2, v3}, Lnx;-><init>(IILjava/lang/String;)V

    sput-object v0, Lnx;->d:Lnx;

    new-instance v0, Lnx;

    const/16 v1, 0x2d8

    const/16 v2, 0x5a

    const-string v3, "as"

    invoke-direct {v0, v1, v2, v3}, Lnx;-><init>(IILjava/lang/String;)V

    sput-object v0, Lnx;->e:Lnx;

    new-instance v0, Lnx;

    const/16 v1, 0xa0

    const/16 v2, 0x258

    const-string v3, "as"

    invoke-direct {v0, v1, v2, v3}, Lnx;-><init>(IILjava/lang/String;)V

    sput-object v0, Lnx;->f:Lnx;

    return-void
.end method

.method private constructor <init>(IILjava/lang/String;)V
    .locals 1

    new-instance v0, Loo;

    invoke-direct {v0, p1, p2}, Loo;-><init>(II)V

    invoke-direct {p0, v0}, Lnx;-><init>(Loo;)V

    return-void
.end method

.method public constructor <init>(Loo;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lnx;->g:Loo;

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    iget-object v0, p0, Lnx;->g:Loo;

    invoke-virtual {v0}, Loo;->b()I

    move-result v0

    return v0
.end method

.method public b()I
    .locals 1

    iget-object v0, p0, Lnx;->g:Loo;

    invoke-virtual {v0}, Loo;->a()I

    move-result v0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    instance-of v0, p1, Lnx;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    check-cast p1, Lnx;

    iget-object v0, p0, Lnx;->g:Loo;

    iget-object v1, p1, Lnx;->g:Loo;

    invoke-virtual {v0, v1}, Loo;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    iget-object v0, p0, Lnx;->g:Loo;

    invoke-virtual {v0}, Loo;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lnx;->g:Loo;

    invoke-virtual {v0}, Loo;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
