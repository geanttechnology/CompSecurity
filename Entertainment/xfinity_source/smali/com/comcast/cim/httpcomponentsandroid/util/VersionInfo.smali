.class public Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;
.super Ljava/lang/Object;
.source "VersionInfo.java"


# instance fields
.field private final infoClassloader:Ljava/lang/String;

.field private final infoModule:Ljava/lang/String;

.field private final infoPackage:Ljava/lang/String;

.field private final infoRelease:Ljava/lang/String;

.field private final infoTimestamp:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "pckg"    # Ljava/lang/String;
    .param p2, "module"    # Ljava/lang/String;
    .param p3, "release"    # Ljava/lang/String;
    .param p4, "time"    # Ljava/lang/String;
    .param p5, "clsldr"    # Ljava/lang/String;

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    if-nez p1, :cond_0

    .line 91
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Package identifier must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 95
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoPackage:Ljava/lang/String;

    .line 96
    if-eqz p2, :cond_1

    .end local p2    # "module":Ljava/lang/String;
    :goto_0
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoModule:Ljava/lang/String;

    .line 97
    if-eqz p3, :cond_2

    .end local p3    # "release":Ljava/lang/String;
    :goto_1
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoRelease:Ljava/lang/String;

    .line 98
    if-eqz p4, :cond_3

    .end local p4    # "time":Ljava/lang/String;
    :goto_2
    iput-object p4, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    .line 99
    if-eqz p5, :cond_4

    .end local p5    # "clsldr":Ljava/lang/String;
    :goto_3
    iput-object p5, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    .line 100
    return-void

    .line 96
    .restart local p2    # "module":Ljava/lang/String;
    .restart local p3    # "release":Ljava/lang/String;
    .restart local p4    # "time":Ljava/lang/String;
    .restart local p5    # "clsldr":Ljava/lang/String;
    :cond_1
    const-string p2, "UNAVAILABLE"

    goto :goto_0

    .line 97
    .end local p2    # "module":Ljava/lang/String;
    :cond_2
    const-string p3, "UNAVAILABLE"

    goto :goto_1

    .line 98
    .end local p3    # "release":Ljava/lang/String;
    :cond_3
    const-string p4, "UNAVAILABLE"

    goto :goto_2

    .line 99
    .end local p4    # "time":Ljava/lang/String;
    :cond_4
    const-string p5, "UNAVAILABLE"

    goto :goto_3
.end method

.method protected static final fromMap(Ljava/lang/String;Ljava/util/Map;Ljava/lang/ClassLoader;)Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;
    .locals 6
    .param p0, "pckg"    # Ljava/lang/String;
    .param p1, "info"    # Ljava/util/Map;
    .param p2, "clsldr"    # Ljava/lang/ClassLoader;

    .prologue
    const/4 v1, 0x1

    .line 275
    if-nez p0, :cond_0

    .line 276
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Package identifier must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 280
    :cond_0
    const/4 v2, 0x0

    .line 281
    .local v2, "module":Ljava/lang/String;
    const/4 v3, 0x0

    .line 282
    .local v3, "release":Ljava/lang/String;
    const/4 v4, 0x0

    .line 284
    .local v4, "timestamp":Ljava/lang/String;
    if-eqz p1, :cond_5

    .line 285
    const-string v0, "info.module"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "module":Ljava/lang/String;
    check-cast v2, Ljava/lang/String;

    .line 286
    .restart local v2    # "module":Ljava/lang/String;
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    if-ge v0, v1, :cond_1

    .line 287
    const/4 v2, 0x0

    .line 289
    :cond_1
    const-string v0, "info.release"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "release":Ljava/lang/String;
    check-cast v3, Ljava/lang/String;

    .line 290
    .restart local v3    # "release":Ljava/lang/String;
    if-eqz v3, :cond_3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v0

    if-lt v0, v1, :cond_2

    const-string v0, "${pom.version}"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 292
    :cond_2
    const/4 v3, 0x0

    .line 294
    :cond_3
    const-string v0, "info.timestamp"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "timestamp":Ljava/lang/String;
    check-cast v4, Ljava/lang/String;

    .line 295
    .restart local v4    # "timestamp":Ljava/lang/String;
    if-eqz v4, :cond_5

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-lt v0, v1, :cond_4

    const-string v0, "${mvn.timestamp}"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 299
    :cond_4
    const/4 v4, 0x0

    .line 302
    :cond_5
    const/4 v5, 0x0

    .line 303
    .local v5, "clsldrstr":Ljava/lang/String;
    if-eqz p2, :cond_6

    .line 304
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 306
    :cond_6
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static final loadVersionInfo(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;
    .locals 7
    .param p0, "pckg"    # Ljava/lang/String;
    .param p1, "clsldr"    # Ljava/lang/ClassLoader;

    .prologue
    .line 228
    if-nez p0, :cond_0

    .line 229
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Package identifier must not be null."

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 233
    :cond_0
    if-nez p1, :cond_1

    .line 234
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Thread;->getContextClassLoader()Ljava/lang/ClassLoader;

    move-result-object p1

    .line 236
    :cond_1
    const/4 v3, 0x0

    .line 240
    .local v3, "vip":Ljava/util/Properties;
    :try_start_0
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    const/16 v5, 0x2e

    const/16 v6, 0x2f

    invoke-virtual {p0, v5, v6}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    const-string v5, "version.properties"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/ClassLoader;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 242
    .local v0, "is":Ljava/io/InputStream;
    if-eqz v0, :cond_2

    .line 244
    :try_start_1
    new-instance v1, Ljava/util/Properties;

    invoke-direct {v1}, Ljava/util/Properties;-><init>()V

    .line 245
    .local v1, "props":Ljava/util/Properties;
    invoke-virtual {v1, v0}, Ljava/util/Properties;->load(Ljava/io/InputStream;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 246
    move-object v3, v1

    .line 248
    :try_start_2
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 255
    .end local v0    # "is":Ljava/io/InputStream;
    .end local v1    # "props":Ljava/util/Properties;
    :cond_2
    :goto_0
    const/4 v2, 0x0

    .line 256
    .local v2, "result":Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;
    if-eqz v3, :cond_3

    .line 257
    invoke-static {p0, v3, p1}, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->fromMap(Ljava/lang/String;Ljava/util/Map;Ljava/lang/ClassLoader;)Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;

    move-result-object v2

    .line 259
    :cond_3
    return-object v2

    .line 248
    .end local v2    # "result":Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;
    .restart local v0    # "is":Ljava/io/InputStream;
    :catchall_0
    move-exception v4

    :try_start_3
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    throw v4
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    .line 251
    .end local v0    # "is":Ljava/io/InputStream;
    :catch_0
    move-exception v4

    goto :goto_0
.end method


# virtual methods
.method public final getClassloader()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    return-object v0
.end method

.method public final getModule()Ljava/lang/String;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoModule:Ljava/lang/String;

    return-object v0
.end method

.method public final getPackage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoPackage:Ljava/lang/String;

    return-object v0
.end method

.method public final getRelease()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoRelease:Ljava/lang/String;

    return-object v0
.end method

.method public final getTimestamp()Ljava/lang/String;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    const/16 v3, 0x3a

    .line 162
    new-instance v0, Ljava/lang/StringBuffer;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoPackage:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, 0x14

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoModule:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoRelease:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 167
    .local v0, "sb":Ljava/lang/StringBuffer;
    const-string v1, "VersionInfo("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoPackage:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoModule:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 172
    const-string v1, "UNAVAILABLE"

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoRelease:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 173
    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoRelease:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 174
    :cond_0
    const-string v1, "UNAVAILABLE"

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 175
    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 177
    :cond_1
    const/16 v1, 0x29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 179
    const-string v1, "UNAVAILABLE"

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 180
    const/16 v1, 0x40

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 182
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
