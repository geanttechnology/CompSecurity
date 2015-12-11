.class public Lgk;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Lgl;

.field private static b:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lgk;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lgk;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    return-void
.end method

.method public static a(Lft;)V
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lft;->a:Lft;

    if-ne p0, v0, :cond_0

    .line 53
    sget-object v0, Lgl;->a:Lgl;

    sput-object v0, Lgk;->a:Lgl;

    .line 65
    :goto_0
    return-void

    .line 54
    :cond_0
    sget-object v0, Lft;->f:Lft;

    if-ne p0, v0, :cond_1

    .line 55
    sget-object v0, Lgl;->b:Lgl;

    sput-object v0, Lgk;->a:Lgl;

    goto :goto_0

    .line 56
    :cond_1
    sget-object v0, Lft;->d:Lft;

    if-ne p0, v0, :cond_2

    .line 57
    sget-object v0, Lgl;->c:Lgl;

    sput-object v0, Lgk;->a:Lgl;

    goto :goto_0

    .line 58
    :cond_2
    sget-object v0, Lft;->c:Lft;

    if-ne p0, v0, :cond_3

    .line 59
    sget-object v0, Lgl;->d:Lgl;

    sput-object v0, Lgk;->a:Lgl;

    goto :goto_0

    .line 60
    :cond_3
    sget-object v0, Lft;->l:Lft;

    if-ne p0, v0, :cond_4

    .line 61
    sget-object v0, Lgl;->e:Lgl;

    sput-object v0, Lgk;->a:Lgl;

    goto :goto_0

    .line 63
    :cond_4
    sget-object v0, Lgl;->a:Lgl;

    sput-object v0, Lgk;->a:Lgl;

    goto :goto_0
.end method
