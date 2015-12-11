.class public Lcom/poshmark/config/BuildTypeConfig;
.super Ljava/lang/Object;
.source "BuildTypeConfig.java"


# static fields
.field public static final BUILD_TYPE:Lcom/poshmark/config/BuildType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 5
    sget-object v0, Lcom/poshmark/config/BuildType;->RELEASE:Lcom/poshmark/config/BuildType;

    sput-object v0, Lcom/poshmark/config/BuildTypeConfig;->BUILD_TYPE:Lcom/poshmark/config/BuildType;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
