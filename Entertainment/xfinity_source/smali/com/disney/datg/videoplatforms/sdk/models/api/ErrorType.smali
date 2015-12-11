.class public Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorType;
.super Ljava/lang/Object;
.source "ErrorType.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorType$ErrorDefinition;
    }
.end annotation


# static fields
.field private static errorMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorType;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 80
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorType;->errorMap:Ljava/util/Map;

    return-void
.end method
