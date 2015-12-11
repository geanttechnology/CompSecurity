.class public Lcom/adobe/mediacore/Version;
.super Ljava/lang/Object;


# static fields
.field private static final FIELD_SEPARATOR:Ljava/lang/String; = "."

.field private static final VERSION:I = 0x1

.field private static final _apiVersion:I

.field private static final _aveVersion:Ljava/lang/String;

.field private static final _buildChangeList:Ljava/lang/String; = "1314461"

.field private static final _major:Ljava/lang/String; = "1"

.field private static final _minor:Ljava/lang/String; = "4.16"

.field private static final _psdkDescription:Ljava/lang/String;

.field private static final _psdkVersion:Ljava/lang/String;

.field private static final _revision:Ljava/lang/String; = "1454"

.field private static final _type:Ljava/lang/String; = "release"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "AVEAndroid"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    invoke-static {}, Lcom/adobe/ave/VideoEngine;->getVersionString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/Version;->_aveVersion:Ljava/lang/String;

    const-string v0, "1.4.16.1454"

    sput-object v0, Lcom/adobe/mediacore/Version;->_psdkVersion:Ljava/lang/String;

    const-string v0, "1.4.16.1454 ( release, 1314461)"

    sput-object v0, Lcom/adobe/mediacore/Version;->_psdkDescription:Ljava/lang/String;

    const/4 v0, 0x1

    sput v0, Lcom/adobe/mediacore/Version;->_apiVersion:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAVEVersion()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/Version;->_aveVersion:Ljava/lang/String;

    return-object v0
.end method

.method public static getApiVersion()I
    .locals 1

    sget v0, Lcom/adobe/mediacore/Version;->_apiVersion:I

    return v0
.end method

.method public static getDescription()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/Version;->_psdkDescription:Ljava/lang/String;

    return-object v0
.end method

.method public static getMajor()Ljava/lang/String;
    .locals 1

    const-string v0, "1"

    return-object v0
.end method

.method public static getMinor()Ljava/lang/String;
    .locals 1

    const-string v0, "4.16"

    return-object v0
.end method

.method public static getRevision()Ljava/lang/String;
    .locals 1

    const-string v0, "1454"

    return-object v0
.end method

.method public static getType()Ljava/lang/String;
    .locals 1

    const-string v0, "release"

    return-object v0
.end method

.method public static getVersion()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/Version;->_psdkVersion:Ljava/lang/String;

    return-object v0
.end method
