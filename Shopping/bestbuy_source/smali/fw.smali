.class public Lfw;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;

.field private static b:Lfx;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lfw;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lfw;->a:Ljava/lang/String;

    .line 15
    sget-object v0, Lfx;->a:Lfx;

    sput-object v0, Lfw;->b:Lfx;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method

.method public static a(Lft;)V
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lft;->a:Lft;

    if-ne p0, v0, :cond_0

    .line 36
    sget-object v0, Lfx;->a:Lfx;

    sput-object v0, Lfw;->b:Lfx;

    .line 46
    :goto_0
    return-void

    .line 37
    :cond_0
    sget-object v0, Lft;->f:Lft;

    if-ne p0, v0, :cond_1

    .line 38
    sget-object v0, Lfx;->b:Lfx;

    sput-object v0, Lfw;->b:Lfx;

    goto :goto_0

    .line 39
    :cond_1
    sget-object v0, Lft;->h:Lft;

    if-ne p0, v0, :cond_2

    .line 40
    sget-object v0, Lfx;->c:Lfx;

    sput-object v0, Lfw;->b:Lfx;

    goto :goto_0

    .line 41
    :cond_2
    sget-object v0, Lft;->l:Lft;

    if-ne p0, v0, :cond_3

    .line 42
    sget-object v0, Lfx;->d:Lfx;

    sput-object v0, Lfw;->b:Lfx;

    goto :goto_0

    .line 44
    :cond_3
    sget-object v0, Lfx;->a:Lfx;

    sput-object v0, Lfw;->b:Lfx;

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 30
    const-string v0, "CUSTOM"

    invoke-static {v0}, Lfx;->a(Ljava/lang/String;)Lfx;

    move-result-object v0

    .line 31
    iput-object p0, v0, Lfx;->e:Ljava/lang/String;

    .line 32
    return-void
.end method
