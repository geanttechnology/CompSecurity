.class public final Lb/a/a/d/ac;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final a:Lb/a/a/d/am;

.field final b:Lb/a/a/d/al;

.field private final c:Ljava/util/Locale;

.field private final d:Lb/a/a/v;


# direct methods
.method public constructor <init>(Lb/a/a/d/am;Lb/a/a/d/al;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    iput-object p1, p0, Lb/a/a/d/ac;->a:Lb/a/a/d/am;

    .line 89
    iput-object p2, p0, Lb/a/a/d/ac;->b:Lb/a/a/d/al;

    .line 90
    iput-object v0, p0, Lb/a/a/d/ac;->c:Ljava/util/Locale;

    .line 91
    iput-object v0, p0, Lb/a/a/d/ac;->d:Lb/a/a/v;

    .line 92
    return-void
.end method

.method private constructor <init>(Lb/a/a/d/am;Lb/a/a/d/al;Ljava/util/Locale;Lb/a/a/v;)V
    .locals 0

    .prologue
    .line 105
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 106
    iput-object p1, p0, Lb/a/a/d/ac;->a:Lb/a/a/d/am;

    .line 107
    iput-object p2, p0, Lb/a/a/d/ac;->b:Lb/a/a/d/al;

    .line 108
    iput-object p3, p0, Lb/a/a/d/ac;->c:Ljava/util/Locale;

    .line 109
    iput-object p4, p0, Lb/a/a/d/ac;->d:Lb/a/a/v;

    .line 110
    return-void
.end method


# virtual methods
.method public final a(Lb/a/a/v;)Lb/a/a/d/ac;
    .locals 4

    .prologue
    .line 187
    iget-object v0, p0, Lb/a/a/d/ac;->d:Lb/a/a/v;

    if-ne p1, v0, :cond_0

    .line 190
    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Lb/a/a/d/ac;

    iget-object v1, p0, Lb/a/a/d/ac;->a:Lb/a/a/d/am;

    iget-object v2, p0, Lb/a/a/d/ac;->b:Lb/a/a/d/al;

    iget-object v3, p0, Lb/a/a/d/ac;->c:Ljava/util/Locale;

    invoke-direct {v0, v1, v2, v3, p1}, Lb/a/a/d/ac;-><init>(Lb/a/a/d/am;Lb/a/a/d/al;Ljava/util/Locale;Lb/a/a/v;)V

    move-object p0, v0

    goto :goto_0
.end method
