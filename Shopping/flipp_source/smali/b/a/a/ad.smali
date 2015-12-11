.class public final Lb/a/a/ad;
.super Lb/a/a/a/f;
.source "SourceFile"


# static fields
.field public static final a:Lb/a/a/ad;

.field public static final b:Lb/a/a/ad;

.field public static final c:Lb/a/a/ad;

.field public static final d:Lb/a/a/ad;

.field public static final e:Lb/a/a/ad;

.field public static final f:Lb/a/a/ad;

.field private static final g:Lb/a/a/d/ac;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 45
    new-instance v0, Lb/a/a/ad;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lb/a/a/ad;-><init>(I)V

    sput-object v0, Lb/a/a/ad;->a:Lb/a/a/ad;

    .line 47
    new-instance v0, Lb/a/a/ad;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lb/a/a/ad;-><init>(I)V

    sput-object v0, Lb/a/a/ad;->b:Lb/a/a/ad;

    .line 49
    new-instance v0, Lb/a/a/ad;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Lb/a/a/ad;-><init>(I)V

    sput-object v0, Lb/a/a/ad;->c:Lb/a/a/ad;

    .line 51
    new-instance v0, Lb/a/a/ad;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Lb/a/a/ad;-><init>(I)V

    sput-object v0, Lb/a/a/ad;->d:Lb/a/a/ad;

    .line 53
    new-instance v0, Lb/a/a/ad;

    const v1, 0x7fffffff

    invoke-direct {v0, v1}, Lb/a/a/ad;-><init>(I)V

    sput-object v0, Lb/a/a/ad;->e:Lb/a/a/ad;

    .line 55
    new-instance v0, Lb/a/a/ad;

    const/high16 v1, -0x80000000

    invoke-direct {v0, v1}, Lb/a/a/ad;-><init>(I)V

    sput-object v0, Lb/a/a/ad;->f:Lb/a/a/ad;

    .line 58
    invoke-static {}, Lb/a/a/d/ab;->a()Lb/a/a/d/ac;

    move-result-object v0

    invoke-static {}, Lb/a/a/v;->a()Lb/a/a/v;

    move-result-object v1

    invoke-virtual {v0, v1}, Lb/a/a/d/ac;->a(Lb/a/a/v;)Lb/a/a/d/ac;

    move-result-object v0

    sput-object v0, Lb/a/a/ad;->g:Lb/a/a/d/ac;

    return-void
.end method

.method private constructor <init>(I)V
    .locals 0

    .prologue
    .line 175
    invoke-direct {p0, p1}, Lb/a/a/a/f;-><init>(I)V

    .line 176
    return-void
.end method

.method public static a(Lb/a/a/z;Lb/a/a/z;)Lb/a/a/ad;
    .locals 2

    .prologue
    .line 102
    invoke-static {}, Lb/a/a/m;->j()Lb/a/a/m;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lb/a/a/a/f;->a(Lb/a/a/z;Lb/a/a/z;Lb/a/a/m;)I

    move-result v1

    .line 103
    sparse-switch v1, :sswitch_data_0

    new-instance v0, Lb/a/a/ad;

    invoke-direct {v0, v1}, Lb/a/a/ad;-><init>(I)V

    :goto_0
    return-object v0

    :sswitch_0
    sget-object v0, Lb/a/a/ad;->a:Lb/a/a/ad;

    goto :goto_0

    :sswitch_1
    sget-object v0, Lb/a/a/ad;->b:Lb/a/a/ad;

    goto :goto_0

    :sswitch_2
    sget-object v0, Lb/a/a/ad;->c:Lb/a/a/ad;

    goto :goto_0

    :sswitch_3
    sget-object v0, Lb/a/a/ad;->d:Lb/a/a/ad;

    goto :goto_0

    :sswitch_4
    sget-object v0, Lb/a/a/ad;->e:Lb/a/a/ad;

    goto :goto_0

    :sswitch_5
    sget-object v0, Lb/a/a/ad;->f:Lb/a/a/ad;

    goto :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        -0x80000000 -> :sswitch_5
        0x0 -> :sswitch_0
        0x1 -> :sswitch_1
        0x2 -> :sswitch_2
        0x3 -> :sswitch_3
        0x7fffffff -> :sswitch_4
    .end sparse-switch
.end method


# virtual methods
.method public final a()Lb/a/a/m;
    .locals 1

    .prologue
    .line 194
    invoke-static {}, Lb/a/a/m;->j()Lb/a/a/m;

    move-result-object v0

    return-object v0
.end method

.method public final b()Lb/a/a/v;
    .locals 1

    .prologue
    .line 203
    invoke-static {}, Lb/a/a/v;->a()Lb/a/a/v;

    move-result-object v0

    return-object v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 2
    .annotation runtime Lorg/joda/convert/ToString;
    .end annotation

    .prologue
    .line 358
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "P"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lb/a/a/a/f;->p:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Y"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
