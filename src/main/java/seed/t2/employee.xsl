<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="fo">

	<xsl:template match="employee">
		<fo:table-row>
			<xsl:if test="designation = 'Manager'">
				<xsl:attribute name="font-weight">bold</xsl:attribute>
			</xsl:if>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="id" />
				</fo:block>
			</fo:table-cell>

			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="name" />
				</fo:block>
			</fo:table-cell>
			<fo:table-cell>
				<fo:block>
					<xsl:value-of select="designation" />
				</fo:block>
			</fo:table-cell>
		</fo:table-row>
	</xsl:template>
</xsl:stylesheet>