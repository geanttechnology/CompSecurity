.class final Lorg/apache/commons/math/MathRuntimeException$4;
.super Ljava/lang/IllegalArgumentException;
.source "MathRuntimeException.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/apache/commons/math/MathRuntimeException;->createIllegalArgumentException(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$arguments:[Ljava/lang/Object;

.field final synthetic val$pattern:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;

    .prologue
    .line 282
    iput-object p2, p0, Lorg/apache/commons/math/MathRuntimeException$4;->val$pattern:Ljava/lang/String;

    iput-object p3, p0, Lorg/apache/commons/math/MathRuntimeException$4;->val$arguments:[Ljava/lang/Object;

    invoke-direct {p0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getLocalizedMessage()Ljava/lang/String;
    .locals 3

    .prologue
    .line 290
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    iget-object v1, p0, Lorg/apache/commons/math/MathRuntimeException$4;->val$pattern:Ljava/lang/String;

    iget-object v2, p0, Lorg/apache/commons/math/MathRuntimeException$4;->val$arguments:[Ljava/lang/Object;

    # invokes: Lorg/apache/commons/math/MathRuntimeException;->buildMessage(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    invoke-static {v0, v1, v2}, Lorg/apache/commons/math/MathRuntimeException;->access$000(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
