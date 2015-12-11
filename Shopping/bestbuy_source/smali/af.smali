.class public final Laf;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private final a:Lorg/json/JSONObject;

.field private final b:J


# direct methods
.method public constructor <init>(Lorg/json/JSONObject;J)V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Laf;->a:Lorg/json/JSONObject;

    .line 19
    iput-wide p2, p0, Laf;->b:J

    .line 20
    return-void
.end method


# virtual methods
.method public final a()J
    .locals 2

    .prologue
    .line 23
    iget-wide v0, p0, Laf;->b:J

    return-wide v0
.end method

.method public final b()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Laf;->a:Lorg/json/JSONObject;

    return-object v0
.end method
