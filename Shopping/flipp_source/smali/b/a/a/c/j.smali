.class public final Lb/a/a/c/j;
.super Lb/a/a/l;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field public static final a:Lb/a/a/l;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lb/a/a/c/j;

    invoke-direct {v0}, Lb/a/a/c/j;-><init>()V

    sput-object v0, Lb/a/a/c/j;->a:Lb/a/a/l;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Lb/a/a/l;-><init>()V

    .line 45
    return-void
.end method


# virtual methods
.method public final a(JI)J
    .locals 3

    .prologue
    .line 117
    int-to-long v0, p3

    invoke-static {p1, p2, v0, v1}, Lb/a/a/c/g;->a(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public final a(JJ)J
    .locals 3

    .prologue
    .line 121
    invoke-static {p1, p2, p3, p4}, Lb/a/a/c/g;->a(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public final a()Lb/a/a/m;
    .locals 1

    .prologue
    .line 49
    invoke-static {}, Lb/a/a/m;->a()Lb/a/a/m;

    move-result-object v0

    return-object v0
.end method

.method public final b(JJ)I
    .locals 3

    .prologue
    .line 125
    invoke-static {p1, p2, p3, p4}, Lb/a/a/c/g;->b(JJ)J

    move-result-wide v0

    invoke-static {v0, v1}, Lb/a/a/c/g;->a(J)I

    move-result v0

    return v0
.end method

.method public final b()Z
    .locals 1

    .prologue
    .line 62
    const/4 v0, 0x1

    return v0
.end method

.method public final c(JJ)J
    .locals 3

    .prologue
    .line 129
    invoke-static {p1, p2, p3, p4}, Lb/a/a/c/g;->b(JJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public final c()Z
    .locals 1

    .prologue
    .line 71
    const/4 v0, 0x1

    return v0
.end method

.method public final synthetic compareTo(Ljava/lang/Object;)I
    .locals 6

    .prologue
    const-wide/16 v4, 0x1

    .line 32
    check-cast p1, Lb/a/a/l;

    invoke-virtual {p1}, Lb/a/a/l;->d()J

    move-result-wide v0

    cmp-long v2, v4, v0

    if-nez v2, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    cmp-long v0, v4, v0

    if-gez v0, :cond_1

    const/4 v0, -0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public final d()J
    .locals 2

    .prologue
    .line 80
    const-wide/16 v0, 0x1

    return-wide v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const-wide/16 v2, 0x1

    const/4 v0, 0x0

    .line 148
    instance-of v1, p1, Lb/a/a/c/j;

    if-eqz v1, :cond_0

    .line 149
    cmp-long v1, v2, v2

    if-nez v1, :cond_0

    const/4 v0, 0x1

    .line 151
    :cond_0
    return v0
.end method

.method public final hashCode()I
    .locals 1

    .prologue
    .line 155
    const/4 v0, 0x1

    return v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 164
    const-string v0, "DurationField[millis]"

    return-object v0
.end method
